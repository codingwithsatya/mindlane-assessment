import { Component } from '@angular/core';
import { WeatherService } from '../weather.service';

@Component({
  selector: 'app-temperature',
  templateUrl: './temperature.component.html',
  styleUrls: ['./temperature.component.css'],
})
export class TemperatureComponent {
  city: string = '';
  weatherDataList: any[] = [];

  constructor(private weatherService: WeatherService) {}

  fetchTemperature(): void {
    this.weatherService.getTemperature(this.city).subscribe((response) => {
      this.weatherDataList.push(response);
    });
  }
}
