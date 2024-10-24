#include <stdio.h>
#include <netdb.h>
#include <stdlib.h>
#include <string.h>

int main( int argc, char *argv[] )
{
  int stat;

  struct addrinfo info, *re;
  memset( &info, 0, sizeof(info) );
  info.ai_socktype = SOCK_STREAM;
  info.ai_family = AF_UNSPEC;
  info.ai_flags = AI_PASSIVE;

  getaddrinfo( NULL, argv[1], &info, &re );

  int fd = socket( re->ai_family, re->ai_socktype, re->ai_protocol );
  if( fd == -1 ){ perror( "socket" ); exit( EXIT_FAILURE ); }

  int flag = 1;
  setsockopt( fd, SOL_SOCKET, SO_REUSEADDR, &flag, sizeof(flag) );

  stat = bind( fd, re->ai_addr, re->ai_addrlen );
  if( stat != 0 ){ perror( "bind" ); exit( EXIT_FAILURE ); }

  freeaddrinfo( re );

  stat = listen( fd, 5 );
  if( stat != 0 ){ perror( "listen" ); exit( EXIT_FAILURE ); }

  struct sockaddr_storage cli_addr;
  socklen_t cli_len = sizeof( cli_addr );
  int fd_new;

  char buff[ 350 ];
  while( 1 )
    {
      fd_new = accept( fd, (struct sockaddr *)&cli_addr, &cli_len );
      if( fd_new == -1 ){ perror( "accept" ); exit( EXIT_FAILURE ); }

      stat = recv( fd_new, buff, sizeof(buff), 0 );
      if( stat == -1 ){ perror( "receive" ); exit( EXIT_FAILURE ); }
      else if( stat == 0 ){ continue; }

      int t = 0;
      char *str1 = strtok( buff, " " );

      while( t <= 1 )
	{
	  printf( "\t%s\t", str1 );
	  str1 = strtok( NULL, " " );
	  t++;
	}// end while

      //printf( "*** received %d bytes ***\n%s\n", stat, buff );
      
      memset( buff, 0, sizeof(buff) );
    }// end while
  
  return 0;
}
