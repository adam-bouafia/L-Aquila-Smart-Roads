import { TestBed } from '@angular/core/testing';

import { AmendsService } from './amends.service';

describe('AmendsService', () => {
  /**
   * The instance of the AmendsService class.
   */
  let service: AmendsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AmendsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
