import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const API_URL = 'http://localhost:8080/api/weather/getTemp';
@Injectable({
  providedIn: 'root',
})
export class WeatherService {
  constructor(private http: HttpClient) {}

  getTemperature(city: string): Observable<any> {
    return this.http.get(API_URL + `?cities=${city}`);
  }
}
