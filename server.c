#include <stdio.h>
#include <stdlib.h>
#include <sys/socket.h>
#include <netinet/in.h>

void fun_error( const char* );
void verify_args( int );
void open_socket( char* );

int main( int numargs, char *arg[] )
{
  verify_args( numargs );
  open_socket( arg[1] );
  return 0;
}

/* Creates a newly socket */

void open_socket( char *port )
{
  /* Create the socket */
  
  int socketfd = socket( PF_INET, SOCK_STREAM, 0 );

  if( socketfd < 0 ) fun_error( "Failed to open socket\n" );

  /* Format the name of the socket */

  struct sockaddr_in name;
  name.sin_family = AF_INET;
  name.sin_port = ;

  /* Give a name to the socket */

  int bindnum = bind( socketfd, ,  );

  if( bindnum < 0 ) fun_error( "Was not possible bind the socket\n" );
}

/* Verify amount of arguments */

void verify_args( int quant )
{
  if( quant > 2 )
    fun_error( "Too many arguments\n" );
  else if( quant < 2 )
    fun_error( "Not enought arguments\n" );
}

/* Error function */

void fun_error( const char *str )
{
  fprintf( stderr, str );
  exit( EXIT_FAILURE );
}
