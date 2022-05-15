import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
	selector: 'app-home',
	templateUrl: './home.component.html',
	styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

	dateTime: Date | undefined;

	constructor() {
		this.dateTime = new Date();
	}

	ngOnInit(): void {
		setInterval(() => {
			this.dateTime = new Date();
		}, 1000);
	}

	bar_name = 'Bank Transfer Schedule';
	title = 'Bank Transfer Schedule';
}
