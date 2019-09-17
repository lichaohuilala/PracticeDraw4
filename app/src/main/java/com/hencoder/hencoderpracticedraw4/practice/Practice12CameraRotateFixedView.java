package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice12CameraRotateFixedView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);
    private Camera camera;
    private Matrix matrix;
    private int p1X;
    private int p1Y;
    private int p2X;
    private int p2Y;

    public Practice12CameraRotateFixedView(Context context) {
        super(context);
    }

    public Practice12CameraRotateFixedView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice12CameraRotateFixedView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
        camera = new Camera();
        matrix = new Matrix();

        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        p1X = point1.x + width / 2;
        p1Y = point1.y + height / 2;
        p2X = point2.x + width / 2;
        p2Y = point2.y + height / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        camera.save();
        matrix.reset();
        camera.rotateX(30);
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-p1X, -p1Y);
        matrix.postTranslate(p1X, p1Y);


        canvas.save();
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();

        camera.save();
        matrix.reset();
        camera.rotateY(30);
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-p2X, -p2Y);
        matrix.postTranslate(p2X, p2Y);

        canvas.save();
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();

    }
}
