import { Component, Input, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
    selector: 'mas-detalles',
    standalone: true,
    imports: [CommonModule],
    templateUrl: './modal-component.html',
    styleUrls: ['./modal-component.css']
})
export class Modal {
    @Input() auto: any;
    @Output() onClose = new EventEmitter<void>();
    @Output() confirmarCompraEvent = new EventEmitter<void>();

    confirmarCompra() {
        this.confirmarCompraEvent.emit();
    }

    cerrar() {
        this.onClose.emit();
    }
}