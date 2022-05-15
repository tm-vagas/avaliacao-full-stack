import { Component, OnInit } from '@angular/core';
import { ListTransactionsService } from '../list-transactions.service';

@Component({
	selector: 'app-list',
	templateUrl: './list.component.html',
	styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit {

	constructor(private listTransactionsService: ListTransactionsService) {
		/* empty */
	}
	getAllTransactions() {
		return this.listTransactionsService.getAllTransactions();
	}

	ngOnInit(): void {
		this.getAllTransactions();
	}

	title = 'app';
	bar_name = 'List all scheduled transactions';
}
