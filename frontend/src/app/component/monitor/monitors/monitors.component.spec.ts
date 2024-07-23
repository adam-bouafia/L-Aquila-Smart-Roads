import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MonitorsComponent } from './monitors.component';

describe('MonitorsComponent', () => {
  let component: MonitorsComponent;
  /**
   * The fixture for the MonitorsComponent.
   */
  let fixture: ComponentFixture<MonitorsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MonitorsComponent],
    });
    fixture = TestBed.createComponent(MonitorsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
