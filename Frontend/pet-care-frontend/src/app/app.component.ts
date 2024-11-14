import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { MascotasService } from './mascotas/mascotas.service';
import { HorarioCuidadoMascota } from './mascotas/mascotas.component';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Pet Care Frontend';
  mascotas: HorarioCuidadoMascota[] = [];
  mascota: HorarioCuidadoMascota = { id: 0, nombreMascota: '', tipo: '', rutina: [] };

  constructor(
    private router: Router,
    private mascotasService: MascotasService,
    private route: ActivatedRoute
  ) {}

  // Método para cargar la lista de mascotas
  loadMascotas(): void {
    this.mascotasService.getMascotas().subscribe((data) => {
      this.mascotas = data;
    });
  }

  // Método para navegar al formulario de una mascota
  navigateToMascotaForm(id?: number) {
    if (id) {
      this.router.navigate([`/mascotas/${id}`]);
    } else {
      this.router.navigate(['/mascotas/new']);
    }
  }

  // Método para eliminar una mascota
  deleteMascota(id: number): void {
    this.mascotasService.deleteMascota(id).subscribe(() => {
      this.loadMascotas();
    });
  }

  // Cargar la mascota para editar (si se pasa un id)
  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id && id !== 'new') {
      this.mascotasService.getMascotaById(+id).subscribe((data) => {
        this.mascota = data;
      });
    }
    this.loadMascotas();
  }

  // Guardar mascota (crear o actualizar)
  saveMascota(): void {
    if (this.mascota.id) {
      this.mascotasService.updateMascota(this.mascota).subscribe(() => {
        this.router.navigate(['/mascotas']);
      });
    } else {
      this.mascotasService.createMascota(this.mascota).subscribe(() => {
        this.router.navigate(['/mascotas']);
      });
    }
  }
}
