/**
 * This file contains the unit tests for the NewMonitorComponent.
 */
import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewMonitorComponent } from './new-monitor.component';

describe('NewMonitorComponent', () => {
  let component: NewMonitorComponent;
  let fixture: ComponentFixture<NewMonitorComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NewMonitorComponent],
    });
    fixture = TestBed.createComponent(NewMonitorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
