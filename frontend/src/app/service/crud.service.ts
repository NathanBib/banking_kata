import {HttpClient, HttpParams} from "@angular/common/http";
import {Router} from "@angular/router";

export class CrudService<T, R> {

  protected http: HttpClient;
  protected router: Router;
  protected endpoint: string;

  constructor(http: HttpClient, router: Router, endpoint: string) {
    this.http = http;
    this.router = router;
    this.endpoint = endpoint;
  }

  findAll(event: any, size: number, search: string | null) {
    let params: HttpParams = new HttpParams();
  }

}
