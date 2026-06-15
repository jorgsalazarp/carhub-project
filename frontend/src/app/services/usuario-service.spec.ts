import { TestBed } from "@angular/core/testing";
import { HttpClientTestingModule, HttpTestingController } from "@angular/common/http/testing";
import { UsuarioService } from "./usuario-service";
import { environment } from "../environments/environments";

describe('UsuarioService', () => {
    let service: UsuarioService;
    let httpMock: HttpTestingController;

    beforeEach(() => {
        TestBed.configureTestingModule({
            imports: [HttpClientTestingModule],
            providers: [UsuarioService]
        });
        service = TestBed.inject(UsuarioService);
        httpMock = TestBed.inject(HttpTestingController);
    });

    afterEach(() => {
        httpMock.verify();
    })
    
    it('Esto DEBERÍA de ejecutar una petición POST para el usuario', () => {
        const mockUsuario = { id:1, nombreUsuario:'test', emailUser:'test@test.com' };

        service.crearUsuario(mockUsuario as any).subscribe(res => {
            expect(res).toEqual(mockUsuario);
        });

        const req = httpMock.expectOne(environment.urlUsuarios);
        expect(req.request.method).toBe('POST');

        req.flush(mockUsuario);
    });
});