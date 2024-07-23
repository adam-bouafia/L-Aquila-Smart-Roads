import { Component } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  ValidationErrors,
  Validators,
} from '@angular/forms';
import { MonitorsService } from '../../../services/monitors.service';
import { Router } from '@angular/router';
import { error } from '@angular/compiler-cli/src/transformers/util';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-new-monitor',
  templateUrl: './new-monitor.component.html',
  styleUrls: ['./new-monitor.component.css'],
})
/**
 * Represents the component for creating a new monitor.
 */
export class NewMonitorComponent {
  monitorFormGroup!: FormGroup;

  constructor(
    private fb: FormBuilder,
    public monitorService: MonitorsService
  ) {}

  ngOnInit(): void {
    this.monitorFormGroup = this.fb.group({
      name: this.fb.control(null, [
        Validators.required,
        Validators.maxLength(4),
      ]),
      maxSpeed: this.fb.control(null, [Validators.min(100)]),
      longitude: this.fb.control(null, [Validators.required]),
      latitude: this.fb.control(null, [Validators.required]),
    });
  }

  handleAddMonitor() {
    let monitor = this.monitorFormGroup.value;
    this.monitorService.addMonitor(monitor).subscribe({
      next: (data) => {
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'Your work has been saved',
          showConfirmButton: false,
          timer: 1500,
        });
        //alert("Monitor Added Successfully")
        this.monitorFormGroup.reset();
      },
      error: (err) => {
        console.log(err);
      },
    });
  }
}
