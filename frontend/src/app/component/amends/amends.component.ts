import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ValidationErrors } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { Amend } from '../../models/amends.model';
import {AmendsService} from "../../services/amends.service";

import pdfMake from "pdfmake/build/pdfmake";
import pdfFonts from "pdfmake/build/vfs_fonts";
import {AuthentificationsService} from "../../services/authentifications.service";
pdfMake.vfs = pdfFonts.pdfMake.vfs;


/**
 * Represents the AmendsComponent class.
 * This component is responsible for displaying and managing the list of amends.
 */
@Component({
  selector: 'app-amends',
  templateUrl: './amends.component.html',
  styleUrls: ['./amends.component.css']
})
export class AmendsComponent implements OnInit {
  amends!: Amend[]; // The list of amends
  errMessage: string = 'Data Not Found!'; // Error message when data is not found

  currentPage: number = 0; // The current page number
  size: number = 4; // The number of items per page
  totalPages: number = 0; // The total number of pages
  currentAction: string = 'all'; // The current action (all or search)

  searchFormGroup!: FormGroup; // The form group for search functionality
  isVehicleInfoVisible: boolean = false; // Flag to indicate if vehicle info is visible
  selectedVehicleAmend: any; // The selected vehicle amend
  isMonitorInfoVisible: boolean = false; // Flag to indicate if monitor info is visible
  selectedMonitorAmend: any; // The selected monitor amend
  isInfraInfoVisible: boolean = false; // Flag to indicate if infrastructure info is visible
  selectedInfraAmend: any; // The selected infrastructure amend

  /**
   * Constructs a new instance of the AmendsComponent class.
   * @param amendsService The service for retrieving amends data
   * @param fb The FormBuilder for creating the search form group
   * @param router The router for navigating to different routes
   * @param authService The authentication service for user authentication
   */
  constructor(
    private amendsService: AmendsService,
    private fb: FormBuilder,
    private router: Router,
    public authService: AuthentificationsService,
  ) {}

  /**
   * Initializes the component.
   */
  ngOnInit(): void {
    this.searchFormGroup = this.fb.group({
      keyword: this.fb.control(null)
    });

    //this.handleGetAllAmends();
    this.getAmends();
  }

  /**
   * Retrieves all amends from the server.
   */
  handleGetAllAmends() {
    this.amendsService.getAllAmends().subscribe({
      next: (data) => {
        this.amends = data;
      },
      error: (err) => {
        this.errMessage = err;
      }
    });
  }

  /**
   * Retrieves amends for the current page from the server.
   */
  getAmends(): void {
    this.amendsService
      .getAllAmendsPages(this.currentPage, this.size)
      .subscribe({
        next: (data) => {
          this.amends = data.content;
          this.totalPages = data.totalPages;
        },
        error: (err) => {
          this.errMessage = "Data Not Found !";
        }
      });
  }

  /**
   * Moves to the next page of amends.
   */
  nextPage() {
    if (this.currentPage < this.totalPages - 1) {
      this.currentPage++;
      this.currentPage = this.currentPage++;
      if (this.currentAction === 'all') this.getAmends();
      else this.handleSearchAmend();
    }
  }

  /**
   * Moves to the previous page of amends.
   */
  previousPage() {
    if (this.currentPage > 0) {
      this.currentPage--;
      this.currentPage = this.currentPage--;
      if (this.currentAction === 'all') this.getAmends();
      else this.handleSearchAmend();
    }
  }

  /**
   * Deletes an amend.
   * @param amend The amend to be deleted
   */
  handledeleteAmend(amend: Amend) {
    Swal.fire({
      title: 'Are you sure?',
      text: "You won't be able to revert this!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
      if (result.isConfirmed) {
        Swal.fire('Deleted!', 'Your file has been deleted.', 'success');

        this.amendsService.deleteAmend(amend.id).subscribe({
          next: (data) => {
            let index = this.amends.indexOf(amend);
            this.amends.splice(index, 1);
          }
        });
      }
    });
  }

  /**
   * Searches for amends based on a keyword.
   */
  handleSearchAmend() {
    this.currentAction = 'search';
    let keyword = this.searchFormGroup.value.keyword;

    this.amendsService.searchAmends(keyword).subscribe({
      next: (data) => {
        this.amends = data.content;
        this.totalPages = data.totalPages;
      }
    });
  }

  /**
   * Navigates to the new amend page.
   */
  handleNewAmend() {
    this.router.navigateByUrl('/newAmend');
  }

  /**
   * Navigates to the edit amend page.
   * @param amend The amend to be edited
   */
  handleEditAmend(amend: Amend) {
    this.router.navigateByUrl('/editAmend/' + amend.id);
  }

  /**
   * Shows the vehicle information.
   * @param i The selected amend
   */
  showVehicle(i: any) {
    this.isVehicleInfoVisible = true;
    this.selectedVehicleAmend = i.vehicle;
  }

  /**
   * Shows the amend information.
   * @param i The selected amend
   */
  showAmend(i: any) {
    this.isVehicleInfoVisible = true;
    this.selectedVehicleAmend = i.vehicle;
    this.isMonitorInfoVisible = true;
    this.selectedMonitorAmend = i.monitor;
  }

  /**
   * Shows the monitor information.
   * @param i The selected amend
   */
  showMonitor(i: any) {
    this.isMonitorInfoVisible = true;
    this.selectedMonitorAmend = i.monitor;
  }

  /**
   * Generates a PDF for the given data.
   * @param data The data to be included in the PDF
   */
  generatePDF(data: any) {
    // Define the document definition
    // Create the document definition
    let documentDefinition = {
      content: [
        { text: '___________________ Amend Report  ___________________', style: 'header' },
        { text: `ID: ${data.id}` },
        { text: `Date: ${data.date}` },
        { text: `Vehicle Matricule: ${data.vehicleMatricule}` },
        { text: `Vehicle Speed: ${data.vehicleSpeed}` },
        { text: `Monitor Max Speed: ${data.monitorMaxSpeed}` },
        { text: `Amend Amount: ${data.amendAmount}` },
        { text: ` ________________________________________________________________________  `, style: 'bigger' },
        { text: `Owne Info :`, style: 'bigger' },
        { text: `Name : ${data.vehicle.owner.name}` },
        { text: `email : ${data.vehicle.owner.email}` },
        { text: ` ________________________________________________________________________  `, style: 'bigger' },
        { text: ` ________________________________________________________________________  `, style: 'bigger' },
        { text: `Monitor Infos :`, style: 'bigger' },
        {
          layout: 'lightHorizontalLines', // optional
          table: {
            body: [
              ['MONITOR ID', 'NAME', 'LONGITUDE', 'LATITUDE'],
              [{ text: `${data.monitorId}` }, { text: `${data.monitor.name}` }, { text: `${data.monitor.longitude}` }, { text: ` ${data.monitor.latitude}` }],
            ]
          }
        },
        { text: ` ________________________________________________________________________  `, style: 'bigger' },
      ],
      styles: {
        header: {
          fontSize: 20,
          bold: true,
        },
        bigger: {
          fontSize: 14,
          bold: true,
        },
      }
    };

    // Generate the PDF
    const pdfDocGenerator = pdfMake.createPdf(documentDefinition);
    pdfDocGenerator.download('amend_report.pdf');
  }

  /**
   * Sets the paid status of an amend.
   * @param i The selected amend
   */
  handleSetPayed(i: any) {
    let p = i.paid;
    i.paid = !p;
  }
}
