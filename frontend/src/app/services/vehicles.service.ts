import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, retry } from 'rxjs';
import { ValidationErrors } from '@angular/forms';
import { Vehicle } from '../models/vehicle.model';
const baseUrl = 'http://localhost:8890/VEHICLES-SERVICE/api/vehicle/';
/**
 * Service for managing vehicles.
 */
@Injectable({
  providedIn: 'root',
})
export class VehiclesService {
  private vehicles!: Vehicle[];
  private errMessage!: string;

  constructor(private http: HttpClient) {
    this.http.get(`${baseUrl}vehicles`).subscribe({
      next: (data) => {
        this.vehicles = data as Vehicle[];
      },
      error: (err) => {
        this.errMessage = err;
      },
    });
  }

  /**
   * Retrieves all vehicles.
   * @returns An Observable that emits an array of Vehicle objects.
   */
  getAllVehicles(): Observable<Vehicle[]> {
    return this.http.get<Vehicle[]>(`${baseUrl}vehicles`).pipe(retry(1));
  }

  /**
   * Adds a new vehicle.
   * @param vehicle - The vehicle object to be added.
   * @returns An Observable that emits the added Vehicle object.
   */
  addVehicle(vehicle: Vehicle): Observable<Vehicle> {
    return this.http.post<Vehicle>(
      `http://localhost:8890/VEHICLES-SERVICE/vehicles`,
      vehicle
    );
  }

  /**
   * Edits an existing vehicle.
   * @param vehicle - The updated vehicle object.
   * @returns An Observable that emits the updated Vehicle object.
   */
  editVehicle(vehicle: Vehicle): Observable<Vehicle> {
    return this.http.put<Vehicle>(
      `http://localhost:8890/VEHICLES-SERVICE/vehicles/${vehicle.id}`,
      vehicle
    );
  }

  /**
   * Deletes a vehicle by its ID.
   * @param id - The ID of the vehicle to be deleted.
   * @returns An Observable that emits a boolean indicating the success of the deletion.
   */
  public deleteVehicle(id: number): Observable<boolean> {
    return this.http.delete<boolean>(
      `http://localhost:8890/VEHICLES-SERVICE/vehicles/${id}`
    );
  }

  /**
   * Searches for vehicles based on a keyword.
   * @param keyword - The keyword to search for.
   * @returns An Observable that emits the search results.
   */
  public searchVehicle(keyword: string): Observable<any> {
    return this.http.get<any>(
      `http://localhost:8890/VEHICLES-SERVICE/api/vehicle/pageVehicleName/${keyword}`
    );
  }

  /**
   * Retrieves a vehicle by its ID.
   * @param id - The ID of the vehicle to retrieve.
   * @returns An Observable that emits the retrieved Vehicle object.
   */
  getVehicle(id: number): Observable<Vehicle> {
    return this.http.get<Vehicle>(
      `http://localhost:8890/VEHICLES-SERVICE/api/vehicle/vehicles/${id}`
    );
  }

  /**
   * Retrieves the error message for a given field and validation error.
   * @param field - The field name.
   * @param error - The validation error object.
   * @returns The error message.
   */
  getErrorMessage(field: string, error: ValidationErrors) {
    if (error['required']) {
      return field + ' is Required !';
    } else if (error['maxlength']) {
      return (
        field +
        ' should have no more than ' +
        error['maxlength']['requiredLength'] +
        ' Characters !'
      );
    } else if (error['min']) {
      return field + ' must be more than ' + error['min']['min'];
    } else return 'Invalid Input!';
  }

  /**
   * Retrieves a specific page of vehicles.
   * @param page - The page number.
   * @param size - The number of vehicles per page.
   * @returns An Observable that emits the requested page of vehicles.
   */
  getAllVehiclesPages(page: number, size: number): Observable<any> {
    return this.http.get<any>(
      `http://localhost:8890/VEHICLES-SERVICE/api/vehicle/pageVehicle?page=${page}&size=${size}`
    );
  }

  /**
   * Retrieves the total count of vehicles.
   * @returns An Observable that emits the total count of vehicles.
   */
  getVehiclesCount(): Observable<number> {
    return this.http.get<number>(
      'http://localhost:8890/VEHICLES-SERVICE/api/vehicle/count'
    );
  }
}
