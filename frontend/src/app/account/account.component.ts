import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {AccountService} from "../service/account.service";
import {Observable} from "rxjs";

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.scss']
})
export class AccountComponent implements OnInit {

  test: string;

  constructor(
    private route: ActivatedRoute, private accountService: AccountService
  ) { }

  ngOnInit(): void {
    this.accountService.get().then();
    this.test = this.accountService.getTest();
  }

}
