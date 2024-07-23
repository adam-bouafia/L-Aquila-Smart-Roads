import { Component } from '@angular/core';
import { MonitorsService } from '../../../services/monitors.service';

import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { Monitor } from '../../../models/monitor.model';

/**
 * Component for displaying and managing monitors.
 */
@Component({
  selector: 'app-monitors',
  templateUrl: './monitors.component.html',
  styleUrls: ['./monitors.component.css'],
})
export class MonitorsComponent {
  /**
   * Array of monitors.
   */
  monitors!: Monitor[];
  /**
   * Error message.
   */
  errMessage!: string;

  /**
   * Current page number.
   */
  currentPage: number = 0;
  /**
   * Number of items per page.
   */
  size: number = 4;
  /**
   * Total number of pages.
   */
  totalPages: number = 0;
  /**
   * Current action.
   */
  currentAction: string = 'all';

  /**
   * Form group for search functionality.
   */
  searchFormGroup!: FormGroup;

  constructor(
    private monitorsService: MonitorsService,
    private fb: FormBuilder,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.searchFormGroup = this.fb.group({
      keyword: this.fb.control(null),
    });

    this.getMonitors();
  }

  /**
   * Retrieves the monitors from the service.
   */
  getMonitors(): void {
    this.monitorsService
      .getAllMonitorsPages(this.currentPage, this.size)
      .subscribe({
        next: (data) => {
          this.monitors = data.content;
          this.totalPages = data.totalPages;
        },
        error: (err) => {
          this.errMessage = 'Data Not Found!';
        },
      });
  }

  /**
   * Moves to the next page of monitors.
   */
  nextPage() {
    if (this.currentPage < this.totalPages - 1) {
      this.currentPage++;
      if (this.currentAction === 'all') this.getMonitors();
      else this.handleSearchMonitor();
    }
  }

  /**
   * Moves to the previous page of monitors.
   */
  previousPage() {
    if (this.currentPage > 0) {
      this.currentPage--;
      if (this.currentAction === 'all') this.getMonitors();
      else this.handleSearchMonitor();
    }
  }

  /**
   * Retrieves all monitors from the service.
   */
  handleGetAllMonitors() {
    this.monitorsService.getAllMonitors().subscribe({
      next: (data) => {
        this.monitors = data;
      },
      error: (err) => {
        this.errMessage = err;
      },
    });
  }

  /**
   * Deletes a monitor.
   * @param r The monitor to be deleted.
   */
  handledeleteMonitor(r: Monitor) {
    Swal.fire({
      title: 'Are you sure?',
      text: "You won't be able to revert this!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, delete it!',
    }).then((result) => {
      if (result.isConfirmed) {
        Swal.fire('Deleted!', 'Your file has been deleted.', 'success');

        this.monitorsService.deleteMonitor(r.id).subscribe({
          next: (data) => {
            let index = this.monitors.indexOf(r);
            this.monitors.splice(index, 1);
          },
        });
      }
    });
  }

  /**
   * Searches for a monitor based on a keyword.
   */
  handleSearchMonitor() {
    this.currentAction = 'search';
    let keyword = this.searchFormGroup.value.keyword;

    this.monitorsService.searchMonitor(keyword).subscribe({
      next: (data) => {
        this.monitors = data.content;
        this.totalPages = data.totalPages;
      },
    });
  }

  /**
   * Navigates to the new monitor page.
   */
  handleNewMonitor() {
    this.router.navigateByUrl('admin/newMonitor');
  }

  /**
   * Navigates to the edit monitor page.
   * @param r The monitor to be edited.
   */
  handleEditMonitor(r: Monitor) {
    this.router.navigateByUrl('admin/editMonitor/' + r.id);
  }

  /**
   * Sets the status of a monitor.
   * @param r The monitor to be updated.
   */
  handleSetOn(r: any) {
    let on = r.status;
    r.status = !on;
  }
}
