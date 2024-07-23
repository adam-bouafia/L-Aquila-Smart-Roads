import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HeaderComponent} from "./component/header/header.component";
import { VehiclesComponent } from './component/vehicles/vehicles.component';
import { OwnersComponent } from './component/owners/owners.component';
import { MonitorsComponent } from './component/monitor/monitors/monitors.component';
import { AmendsComponent } from './component/amends/amends.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { NewMonitorComponent } from './component/monitor/new-monitor/new-monitor.component';
import { EditMonitorComponent } from './component/monitor/edit-monitor/edit-monitor.component';
import {DashboardComponent} from "./component/dashboard/dashboard.component";
import { AdminTemplateComponent } from './component/admin-template/admin-template.component';
import {AuthentificationsComponent} from "./component/authentifications/authentifications.component";
import { WelcomeComponent } from './component/welcome/welcome.component';
import { CommonModule } from '@angular/common';


/**
 * The root module of the application.
 */
@NgModule({
    declarations: [
        AppComponent,
        HeaderComponent,
        VehiclesComponent,
        OwnersComponent,
        MonitorsComponent,
        AmendsComponent,
        NewMonitorComponent,
        EditMonitorComponent,
        DashboardComponent,
        AdminTemplateComponent,
        AuthentificationsComponent,
        WelcomeComponent
    ],
  imports: [
    BrowserModule,
    CommonModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
