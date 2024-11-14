import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HorarioCuidadoMascota } from './api';

@Injectable({
  providedIn: 'root'
})
export class MascotasService {
  private apiUrl = 'http://localhost:8080/api/mascotas'; // Cambiar por la URL de tu API

  constructor(private http: HttpClient) {}

  getMascotas(): Observable<HorarioCuidadoMascota[]> {
    return this.http.get<HorarioCuidadoMascota[]>(this.apiUrl);
  }

  getMascotaById(id: number): Observable<HorarioCuidadoMascota> {
    return this.http.get<HorarioCuidadoMascota>(`${this.apiUrl}/${id}`);
  }

  createMascota(mascota: HorarioCuidadoMascota): Observable<HorarioCuidadoMascota> {
    return this.http.post<HorarioCuidadoMascota>(this.apiUrl, mascota);
  }

  updateMascota(mascota: HorarioCuidadoMascota): Observable<HorarioCuidadoMascota> {
    return this.http.put<HorarioCuidadoMascota>(`${this.apiUrl}/${mascota.id}`, mascota);
  }

  deleteMascota(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
