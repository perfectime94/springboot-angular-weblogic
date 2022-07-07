import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient, HttpResponse} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class PdfService {

  private readonly url: string


  constructor(private http: HttpClient) {
    this.url = 'http://localhost:7001/backend/api/pdf/';
  }

  export(texto: string): Observable<HttpResponse<any>> {
    let newurl = this.url + texto
    return this.http.get(newurl, {
      observe: 'response',
      responseType: 'blob'
    });
  }


}
