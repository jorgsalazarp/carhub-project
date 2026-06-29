import { Component, Input, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
    selector: 'compra-auto',
    standalone: true,
    imports: [CommonModule],
    templateUrl: './checkout.html',
    styleUrls: ['./checkout.css']
})
export class CompraAuto {
    @Input() autoCompra: any;
    @Output() onCancelar = new EventEmitter<void>();
    
    cancelar() {
        this.onCancelar.emit()
    }
}