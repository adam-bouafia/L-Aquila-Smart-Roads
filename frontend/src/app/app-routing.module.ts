import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './component/dashboard/dashboard.component';
import { MonitorsComponent } from './component/monitor/monitors/monitors.component';
import { VehiclesComponent } from './component/vehicles/vehicles.component';
import { AmendsComponent } from './component/amends/amends.component';
import { NewMonitorComponent } from './component/monitor/new-monitor/new-monitor.component';
import { EditMonitorComponent } from './component/monitor/edit-monitor/edit-monitor.component';
import { AdminTemplateComponent } from './component/admin-template/admin-template.component';
import { AuthenticationGuard } from './component/guards/authentication.guard';
import { AuthentificationsComponent } from './component/authentifications/authentifications.component';
import { WelcomeComponent } from './component/welcome/welcome.component';

/**
 * The routes configuration for the application.
 */
const routes: Routes = [
  {
    path: 'admin',
    component: AdminTemplateComponent,
    canActivate: [AuthenticationGuard],
    children: [
      { path: '', component: WelcomeComponent },
      { path: 'dashboard', component: DashboardComponent },
      { path: 'monitors', component: MonitorsComponent },
      { path: 'vehicles', component: VehiclesComponent },
      { path: 'amends', component: AmendsComponent },
      { path: 'newMonitor', component: NewMonitorComponent },
      { path: 'editMonitor/:id', component: EditMonitorComponent },
    ],
  },
  { path: '', component: AuthentificationsComponent },
  { path: 'login', component: AuthentificationsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
