import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class AccountService {
  constructor(private http: HttpClient) {
  }

  get() {
    return this.http.get("http://localhost:8080/api/account/statement/").toPromise();
  }
}
