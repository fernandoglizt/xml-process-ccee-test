import { HttpClient, HttpEvent, HttpHeaders, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AgentsService {

  private baseUrl = 'http://localhost:8080/api/v1/agent';

  constructor(private http: HttpClient) { }

  upload(file: File): Observable<HttpEvent<any>> {
    const formData: FormData = new FormData();

    formData.append('file', file, file.name);

    const req = new HttpRequest('POST', `${this.baseUrl}/file/process`, formData, {
      reportProgress: true,
      responseType: 'json'
    });

    return this.http.request(req);
  }
}
