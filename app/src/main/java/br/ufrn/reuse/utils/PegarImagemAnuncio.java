package br.ufrn.reuse.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by nalbertg on 07/11/2017.
 * @author Nalbert Gabriel Melo Leal
 */

public class PegarImagemAnuncio extends AsyncTask<String, String, Bitmap> {

    Logger logger = Logger.getLogger(getClass().getName());
    ImageView anuncioImage;

    public PegarImagemAnuncio(ImageView i) {
        this.anuncioImage = i;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        Bitmap myBitmap = null;
        try {
            InputStream input = HttpUtils.recoverInputStream(params[0]);
            myBitmap = BitmapFactory.decodeStream(input);
            this.anuncioImage.setImageBitmap(myBitmap);

            return myBitmap;
        } catch (IOException ioException) {
            logger.log(Level.SEVERE,"Erro de IO ao recuperar foto do objeto do anÃºncio", ioException);
        }
        return myBitmap;
    }

}
