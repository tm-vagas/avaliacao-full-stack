import { TestBed } from '@angular/core/testing';

import { ListTransactionsService } from './list-transactions.service';

describe('ListTransactionsService', () => {
  let service: ListTransactionsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ListTransactionsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
