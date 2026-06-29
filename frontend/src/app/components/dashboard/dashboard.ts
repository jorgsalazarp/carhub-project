import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FooterComponent } from '../footer-component/footer-component';
import { Modal } from '../modal/modal-component';
import { CompraAuto } from "../checkout/checkout";

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule, FooterComponent, Modal, CompraAuto],
  templateUrl: './dashboard.html',
  styleUrls: ['./dashboard.css'],
})
export class DashboardComponent {
  mostrarModal: boolean = false;
  mostrarCheckout: boolean = false;
  autoSeleccionado: any = null;

  abrirDetalles(auto: any) {
    this.autoSeleccionado = auto;
    this.mostrarModal = true;
  }

  autoCompra() {
    this.mostrarModal = false;
    this.mostrarCheckout = true;
  }

  cancelaCompra() {
    this.mostrarCheckout = false;
    this.autoSeleccionado = null;
  }

  cerrarModal() {
    this.mostrarModal = false;
  }

  constructor(private router: Router) { }
  
    logout(): void {
      localStorage.removeItem('token');
      this.router.navigate(['/register']);
  }
}
