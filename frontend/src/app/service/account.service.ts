import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Name} from "../types/name";

@Injectable()
export class AccountService {
  constructor(private http: HttpClient) {
  }

  get() {
    return this.http.get("/api/account/statement/").toPromise();
  }

  getTest() {
    //return "test";
    return this.http.get<Name>("/api/account/test/");
  }
}
