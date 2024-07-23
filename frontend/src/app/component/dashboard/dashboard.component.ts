import { Component, OnInit } from '@angular/core';
import {MonitorsService} from "../../services/monitors.service";
import {VehiclesService} from "../../services/vehicles.service";
import {AmendsService} from "../../services/amends.service";
import {AuthentificationsService} from "../../services/authentifications.service";

/**
 * Represents the dashboard component.
 */
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  /**
   * The count of monitors.
   */
  monitorsCount!: number;

  /**
   * The count of vehicles.
   */
  vehicleCount!: number;

  /**
   * The count of amends.
   */
  amendsCount!: number;

  constructor(public monitorService: MonitorsService,
              public vehicleService: VehiclesService,
              public amendService: AmendsService,
              public authService: AuthentificationsService) { }

  ngOnInit(): void {
    this.getMonitorsCount();
    this.getVehiclesCount();
    this.getAmendsCount();
  }

  /**
   * Retrieves the count of monitors.
   */
  getMonitorsCount() {
    this.monitorService.getMonitorsCount()
      .subscribe(count => {
        this.monitorsCount = count;
      });
  }

  /**
   * Retrieves the count of vehicles.
   */
  getVehiclesCount() {
    this.vehicleService.getVehiclesCount()
      .subscribe(count => {
        this.vehicleCount = count;
      });
  }

  /**
   * Retrieves the count of amends.
   */
  getAmendsCount() {
    this.amendService.getAmendsCount()
      .subscribe(count => {
        this.amendsCount = count;
      });
  }
}
