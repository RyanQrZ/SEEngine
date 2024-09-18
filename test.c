#include <stdio.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <stdlib.h>

int main( int argc, char *argv[] )
{
  int sockfd = socket( PF_INET, SOCK_STREAM, 0 );

  int sockfd2 = socket( PF_INET, SOCK_STREAM, 0 );
  
  struct sockaddr_in name;
  name.sin_port = htons( atol( portnum ) );
  name.sin_family = AF_INET;
  name.sin_addr.s_addr = INADDR_ANY;

  int bindnum = bind(sockfd,
		     ( struct sockaddr * ) &name,
		     sizeof(name) );

  if( bindnum < 0 ) fprintf( stderr, "Erro no enderecamento\n" );

  int status = listen( sockfd, 1 );

  if( status < 0 ) fprintf( stderr, "nao esta escutando\n");

  while(1);

  return 0;
}
