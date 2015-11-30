/* MediaUtil LLJTran - $RCSfile: BlockMakerNoteHandler.java,v $
 * Copyright (C) 1999-2005 Dmitriy Rogatkin, Suresh Mahalingam.  All rights reserved.
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *  THIS SOFTWARE IS PROVIDED BY THE AUTHOR AND CONTRIBUTORS ``AS IS'' AND
 *  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 *  IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 *  ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR OR CONTRIBUTORS BE LIABLE FOR
 *  ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *  (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *  LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *  ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *  $Id: BlockMakerNoteHandler.java,v 1.1 2006/12/22 21:30:16 vicne Exp $
 *
 * Some ideas and algorithms were borrowed from:
 * Thomas G. Lane, and James R. Weeks
 * Contribution for Maker Notes handling by Vincent Deconinck
 *
 */
package mediautil.image.jpeg.maker;

import mediautil.image.jpeg.Exif;
import mediautil.image.jpeg.IFD;

import java.io.OutputStream;
import java.io.IOException;

/**
 * This handler stores the Makernotes as a block of raw data. No interpretation is made.
 * 
 * @see MakerNoteHandler
 */
public class BlockMakerNoteHandler implements MakerNoteHandler {
    public void load(Exif exif, IFD ifd, int tag, int type, int offset, int count, int typelen) {
        exif.storeValue(ifd, tag, type, offset, count, typelen);
    }

    public void save(OutputStream out, Exif exif, IFD ifd1) throws IOException {
        out.write(exif.n2s(1, 4));
    }
}
