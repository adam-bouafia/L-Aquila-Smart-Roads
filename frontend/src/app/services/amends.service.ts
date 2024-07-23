import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Amend } from '../models/amends.model';

const baseUrl = '${this.env.get('API_URL')}/AMEND-SERVICE/';

/**
 * Service for managing amends.
 */
@Injectable({
  providedIn: 'root',
})
export class AmendsService {
  constructor(private http: HttpClient) {}

  /**
   * Retrieves all amends.
   * @returns An Observable of an array of Amends.
   */
  getAllAmends(): Observable<Amend[]> {
    return this.http.get<Amend[]>(
      `${this.env.get('API_URL')}/AMEND-SERVICE/api/amend/fullAmends`
    );
  }

  /**
   * Adds a new amend.
   * @param amend - The amend to add.
   * @returns An Observable of the added Amend.
   */
  addAmend(amend: Amend): Observable<Amend> {
    return this.http.post<Amend>(`${baseUrl}amends`, amend);
  }

  /**
   * Edits an existing amend.
   * @param amend - The amend to edit.
   * @returns An Observable of the edited Amend.
   */
  editAmend(amend: Amend): Observable<Amend> {
    return this.http.put<Amend>(`${baseUrl}amends/${amend.id}`, amend);
  }

  /**
   * Deletes an amend by its ID.
   * @param id - The ID of the amend to delete.
   * @returns An Observable indicating whether the amend was successfully deleted.
   */
  deleteAmend(id: number): Observable<boolean> {
    return this.http.delete<boolean>(`${baseUrl}amends/${id}`);
  }

  /**
   * Searches for amends by keyword.
   * @param keyword - The keyword to search for.
   * @returns An Observable of the search results.
   */
  searchAmends(keyword: string): Observable<any> {
    return this.http.get<any>(
      `${baseUrl}api/amend/pageAmendByVehicleMatricule/${keyword}`
    );
  }

  /**
   * Retrieves an amend by its ID.
   * @param id - The ID of the amend to retrieve.
   * @returns An Observable of the retrieved Amend.
   */
  getAmend(id: number): Observable<Amend> {
    return this.http.get<Amend>(`${baseUrl}api/amend/amends/${id}`);
  }

  /**
   * Gets the error message for a specific field and error.
   * @param field - The field name.
   * @param error - The error object.
   * @returns The error message.
   */
  getErrorMessage(field: string, error: any): string {
    if (error.required) {
      return field + ' is required!';
    } else if (error.maxlength) {
      return (
        field +
        ' should have no more than ' +
        error.maxlength.requiredLength +
        ' characters!'
      );
    } else if (error.min) {
      return field + ' must be more than ' + error.min.min + ' km/h!';
    } else {
      return 'Invalid input!';
    }
  }

  /**
   * Retrieves a specific page of amends.
   * @param page - The page number.
   * @param size - The number of items per page.
   * @returns An Observable of the page of amends.
   */
  getAllAmendsPages(page: number, size: number): Observable<any> {
    return this.http.get<any>(
      `${this.env.get('API_URL')}/AMEND-SERVICE/api/amend/fullAmendsPages?page=${page}&size=${size}`
    );
  }

  /**
   * Retrieves the total count of amends.
   * @returns An Observable of the total count of amends.
   */
  getAmendsCount(): Observable<number> {
    return this.http.get<number>(
      `${this.env.get('API_URL')}/AMEND-SERVICE/api/amend/count`
    );
  }
}
