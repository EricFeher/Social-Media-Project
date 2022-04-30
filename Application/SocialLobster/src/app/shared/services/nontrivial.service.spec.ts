import { TestBed } from '@angular/core/testing';

import { NontrivialService } from './nontrivial.service';

describe('UsernamebyfollowercountService', () => {
  let service: NontrivialService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NontrivialService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
