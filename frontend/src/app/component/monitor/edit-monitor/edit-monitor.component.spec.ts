import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditMonitorComponent } from './edit-monitor.component';

describe('EditMonitorComponent', () => {
  let component: EditMonitorComponent;
  /**
   * The fixture for the EditMonitorComponent.
   *
   * @type {ComponentFixture<EditMonitorComponent>}
   */
  let fixture: ComponentFixture<EditMonitorComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EditMonitorComponent],
    });
    fixture = TestBed.createComponent(EditMonitorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
