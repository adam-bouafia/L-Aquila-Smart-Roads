import { TestBed } from '@angular/core/testing';

import { VehiclesService } from './vehicles.service';

describe('VehiclesService', () => {
  /**
   * The instance of the VehiclesService class used for testing.
   */
  let service: VehiclesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VehiclesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
