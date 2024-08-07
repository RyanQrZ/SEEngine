
	org 0x7c00

	bits 16
	
segments:
	mov eax, 0x0
	mov es, eax

clear_scr:
 	mov al, 0x3
 	int 0x10

print_str:
	mov ax, 0x1300
  	mov bl, 0x2
 	mov bh, 0x0
	mov cx, str2 - str1
	mov dx, 0x0
	mov bp, str1
	int 0x10

	mov ax, 0x1300
  	mov bl, 0x17
 	mov bh, 0x0
	mov cx, halt - str2
	mov dh, 0x1
	mov bp, str2
	int 0x10

	mov ax, 0x1300
	mov bx, 0x2
	mov cx, str2 - str1
	mov dh, 0x2
	mov bp, str1
	int 0x10

str1:	db "*****************"

str2:	db "* W.E.L.C.O.M.E *"

halt:
	jmp halt

final:
	times 510 - ( $ - $$ ) db 0 ;
	dw 0xaa55
