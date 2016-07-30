// -*-c++-*-

/***************************************************************************
                                 gzstream.hpp
                      Compression and decompression streams
                             -------------------
    begin                : 14-DEC-2003
    copyright            : (C) 2002, 2003 by The RoboCup Soccer Server 
                           Maintenance Group.
    email                : sserver-admin@lists.sourceforge.net
 ***************************************************************************/

/***************************************************************************
 *                                                                         *
 *   This program is free software; you can redistribute it and/or modify  *
 *   it under the terms of the GNU LGPL as published by the Free Software  *
 *   Foundation; either version 2 of the License, or (at your option) any  *
 *   later version.                                                        *
 *                                                                         *
 ***************************************************************************/

#ifndef GZSTREAM_H
#define GZSTREAM_H

#include "../rcssbaseconfig.hpp"

#include <iostream>
#include <boost/shared_ptr.hpp>


namespace rcss
{
    namespace gz
    {
		class gzstreambuf_impl;
		
		class gzstreambuf
			: public std::streambuf
		{
		public:
			typedef int int_type;
			typedef char char_type;
			
			RCSSBASE_API
			gzstreambuf( std::streambuf& strm,
						 unsigned int bufsize = 8192 );

			RCSSBASE_API
			~gzstreambuf ();
			
			RCSSBASE_API
			bool
			setLevel( int level );

		protected:
			enum Flush { NO_FLUSH = 0,
						 PARTIAL_FLUSH  = 1, /* will be removed, use SYNC_FLUSH instead */
						 SYNC_FLUSH = 2,
						 FULL_FLUSH = 3,
						 FINISH = 4 };

	    
			RCSSBASE_API
			bool
			writeData( int sync = NO_FLUSH );
                
			RCSSBASE_API
			int_type
			overflow( int_type c );

			RCSSBASE_API
			int
			sync();

			RCSSBASE_API
			int_type
			underflow();

		private:
			int
			readData( char* dest, int& dest_size );
			
			// not for use
			gzstreambuf(const gzstreambuf&);
			gzstreambuf& operator=(const gzstreambuf&);

			std::streambuf& M_strmbuf;
			std::ostream* M_output_stream;     // used for writing to M_strmbuf
			std::istream* M_input_stream;      // used for reading from M_strmbuf
			std::streamsize M_buffer_size; // size of the following buffers
			char_type *M_read_buffer;     // used to read compressed data from M_strmbuf
			char_type *M_input_buffer;    // used to buffer uncompressed input to
			// this stream
			char_type *M_output_buffer;   // used to buffer uncompressed output from
			// this stream 
			char_type *M_write_buffer;    // used to write compressed data to M_strmbuf
			
			int M_remained;               // number of bytes remaining in M_output_buffer
			char_type M_remaining_char;

			boost::shared_ptr< gzstreambuf_impl > m_streams;
			int M_level;                  // current level of compression/decompression
			// a level of -1 indicates that data is read
			// and written without modification.
		};
		
		class gzstream
			: public gzstreambuf,
			  public std::iostream
		{
		public:
			RCSSBASE_API
			gzstream( std::streambuf& strm, unsigned int buffer_size = 8192 );
	    
			gzstream( std::iostream& strm, unsigned int buffer_size = 8192 );
	    
	private:
			// not for use
			gzstream( const gzstream& );
			gzstream& operator=( const gzstream& );
	};


		class gzistream
			: public gzstreambuf,
			  public std::istream
		{
		public:
	    
			RCSSBASE_API
			gzistream( std::streambuf& src, unsigned int buffer_size = 8192 );
	    
			RCSSBASE_API
			gzistream( std::istream& src, unsigned int buffer_size = 8192 );
			
		private:
			// not for use
			gzistream( const gzistream& );
			gzistream& operator=( const gzistream& );
		};

		class gzostream
			: public gzstreambuf,
			  public std::ostream
		{
		public:

			RCSSBASE_API
			gzostream( std::streambuf& dest, unsigned int buffer_size = 8192 );
	    
			RCSSBASE_API
			gzostream( std::ostream& dest, unsigned int buffer_size = 8192 );

		private:
			// not for use
			gzostream( const gzostream& );
			gzostream& operator=( const gzostream& );
		};
    } // namespace gz
} // namespace rcss

#endif

