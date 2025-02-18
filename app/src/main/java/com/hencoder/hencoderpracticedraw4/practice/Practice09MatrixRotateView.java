package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice09MatrixRotateView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);
    private Matrix matrix;
    private int coreX1;
    private int coreY1;
    private int coreX2;
    private int coreY2;

    public Practice09MatrixRotateView(Context context) {
        super(context);
    }

    public Practice09MatrixRotateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice09MatrixRotateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
        matrix = new Matrix();
        coreX1 = bitmap.getWidth() / 2 + point1.x;
        coreY1 = bitmap.getHeight() / 2 + point1.y;


        coreX2 = bitmap.getWidth() / 2 + point2.x;
        coreY2 = bitmap.getHeight() / 2 + point2.y;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        matrix.reset();
        matrix.postRotate(180, coreX1, coreY1);
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();

        canvas.save();
        matrix.reset();
        matrix.postRotate(45, coreX2, coreY2);
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();

    }
}
