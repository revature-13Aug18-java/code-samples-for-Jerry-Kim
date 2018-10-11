import { TestBed } from '@angular/core/testing';

import { FoodcallService } from './foodcall.service';

describe('FoodcallService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FoodcallService = TestBed.get(FoodcallService);
    expect(service).toBeTruthy();
  });
});
