import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MonitorsService } from '../../../services/monitors.service';
import { ActivatedRoute, Router } from '@angular/router';

import Swal from 'sweetalert2';
import { Monitor } from '../../../models/monitor.model';
/**
 * Component for editing a monitor.
 */
@Component({
  selector: 'app-edit-monitor',
  templateUrl: './edit-monitor.component.html',
  styleUrls: ['./edit-monitor.component.css'],
})
export class EditMonitorComponent {
  monitorId!: number;
  monitor!: Monitor;
  monitorFormGroup!: FormGroup;

  constructor(
    private fb: FormBuilder,
    private router: Router,
    public monitorService: MonitorsService,
    private route: ActivatedRoute
  ) {
    this.monitorId = this.route.snapshot.params['id'];
  }

  /**
   * Initializes the component.
   */
  ngOnInit(): void {
    this.monitorService.getMonitor(this.monitorId).subscribe({
      next: (data) => {
        this.monitor = data;

        this.monitorFormGroup = this.fb.group({
          name: this.fb.control(this.monitor.name, [
            Validators.required,
            Validators.maxLength(4),
          ]),
          maxSpeed: this.fb.control(this.monitor.maxSpeed, [
            Validators.min(100),
          ]),
          longitude: this.fb.control(this.monitor.longitude, [
            Validators.required,
          ]),
          latitude: this.fb.control(this.monitor.latitude, [
            Validators.required,
          ]),
        });
      },
      error: (err) => {
        console.log(err);
      },
    });
  }

  /**
   * Handles the edit monitor action.
   */
  handleEditMonitor() {
    let r = this.monitorFormGroup.value;
    r.id = this.monitor.id;

    Swal.fire({
      title: 'Do you want to save the changes?',
      //showDenyButton: true,
      showCancelButton: true,
      confirmButtonText: 'Save',
      denyButtonText: `Don't save`,
    }).then((result) => {
      /* Read more about isConfirmed, isDenied below */
      if (result.isConfirmed) {
        Swal.fire('Saved!', '', 'success');

        this.monitorService.editMonitor(r).subscribe({
          next: (data) => {
            //alert("Monitor Updated Successfully")
            this.router.navigate(['/monitors']);
            this.monitorFormGroup.reset();
          },
          error: (err) => {
            console.log(err);
          },
        });
      } else if (result.isDenied) {
        Swal.fire('Changes are not saved', '', 'info');
      }
    });
  }
}
