import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AmendsComponent } from './amends.component';

describe('AmendsComponent', () => {
  let component: AmendsComponent;
  /**
   * The fixture for the AmendsComponent.
   */
  let fixture: ComponentFixture<AmendsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AmendsComponent]
    });
    fixture = TestBed.createComponent(AmendsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
