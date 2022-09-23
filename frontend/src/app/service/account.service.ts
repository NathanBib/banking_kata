import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class AccountService {
  constructor(private http: HttpClient) {
  }

  get() {
    return this.http.get("/api/account/statement/").toPromise();
  }

  getTest() {
    return "test";
    //return this.http.get<string>("/api/account/test");
  }
}
