import { Injectable } from '@angular/core';
import { Observable, of, retry, throwError } from 'rxjs';
import { PageMonitor, Monitor } from '../models/monitor.model';
import { HttpClient, HttpParams } from '@angular/common/http';
import { ValidationErrors } from '@angular/forms';

const baseUrl = '${this.env.get('API_URL')}/MONITOR-SERVICE/api/monitor/';

/**
 * Service for managing monitors.
 */
@Injectable({
  providedIn: 'root',
})
export class MonitorsService {
  private monitors!: Monitor[]; // Array of monitors
  private errMessage!: string; // Error message

  constructor(private http: HttpClient) {
    // Fetch monitors data from the server
    this.http
      .get('${this.env.get('API_URL')}/MONITOR-SERVICE/api/monitor/monitors')
      .subscribe({
        next: (data) => {
          this.monitors = data as Monitor[];
        },
        error: (err) => {
          this.errMessage = err;
        },
      });
  }

  /**
   * Get all monitors.
   * @returns An observable of Monitor array.
   */
  getAllMonitors(): Observable<Monitor[]> {
    return this.http.get<Monitor[]>(`${baseUrl}monitors`).pipe(retry(1));
  }

  /**
   * Add a new monitor.
   * @param monitor - The monitor to add.
   * @returns An observable of the added monitor.
   */
  addMonitor(monitor: Monitor): Observable<Monitor> {
    return this.http.post<Monitor>(
      `${this.env.get('API_URL')}/MONITOR-SERVICE/monitors`,
      monitor
    );
  }

  /**
   * Edit an existing monitor.
   * @param monitor - The monitor to edit.
   * @returns An observable of the edited monitor.
   */
  editMonitor(monitor: Monitor): Observable<Monitor> {
    return this.http.put<Monitor>(
      `${this.env.get('API_URL')}/MONITOR-SERVICE/monitors/${monitor.id}`,
      monitor
    );
  }

  /**
   * Delete a monitor.
   * @param id - The ID of the monitor to delete.
   * @returns An observable indicating the success of the deletion.
   */
  public deleteMonitor(id: number): Observable<boolean> {
    return this.http.delete<boolean>(
      `${this.env.get('API_URL')}/MONITOR-SERVICE/monitors/${id}`
    );
  }

  /**
   * Search for a monitor by keyword.
   * @param keyword - The keyword to search for.
   * @returns An observable of the search results.
   */
  public searchMonitor(keyword: string): Observable<any> {
    return this.http.get<any>(
      `${this.env.get('API_URL')}/MONITOR-SERVICE/api/monitor/pageMonitorName/${keyword}`
    );
  }

  /**
   * Get a monitor by ID.
   * @param id - The ID of the monitor to retrieve.
   * @returns An observable of the retrieved monitor.
   */
  getMonitor(id: number): Observable<Monitor> {
    return this.http.get<Monitor>(
      `${this.env.get('API_URL')}/MONITOR-SERVICE/api/monitor/monitors/${id}`
    );
  }

  /**
   * Get the error message for a specific field and error.
   * @param field - The field name.
   * @param error - The validation error.
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
      return field + ' must be more than ' + error['min']['min'] + ' km/h !';
    } else return 'Invalid Input!';
  }

  /**
   * Get all monitors with pagination.
   * @param page - The page number.
   * @param size - The number of monitors per page.
   * @returns An observable of the paginated monitors.
   */
  getAllMonitorsPages(page: number, size: number): Observable<any> {
    return this.http.get<any>(
      `${this.env.get('API_URL')}/MONITOR-SERVICE/api/monitor/pageMonitor?page=${page}&size=${size}`
    );
  }

  /**
   * Get the total count of monitors.
   * @returns An observable of the total count.
   */
  getMonitorsCount(): Observable<number> {
    return this.http.get<number>(
      '${this.env.get('API_URL')}/MONITOR-SERVICE/api/monitor/count'
    );
  }
}
