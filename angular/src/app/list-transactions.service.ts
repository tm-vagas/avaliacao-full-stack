import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
	providedIn: 'root'
})
export class ListTransactionsService {

	allTransactions: any = [];

	constructor(private http: HttpClient) {
		this.http.get('api/transfer/schedule').subscribe(data => { this.allTransactions = data; });
	}

	getAllTransactions() {
		return this.allTransactions;
	}
}
