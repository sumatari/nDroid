package com.dcodepages.doodle;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Bundle;
import android.os.Environment;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Bitmap DrawBitmap;
	private Canvas mCanvas;
	private Path mPath;
	private Paint DrawBitmapPaint;
	RelativeLayout Rl;
	CustomView View;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		View = new CustomView(this);
		Rl = (RelativeLayout) findViewById(R.id.Rel);
		Rl.addView(View);
		mPaint = new Paint();
		mPaint.setAntiAlias(true);
		mPaint.setDither(true);
		mPaint.setColor(getResources()
				.getColor(android.R.color.holo_green_dark));
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setStrokeJoin(Paint.Join.ROUND);
		mPaint.setStrokeCap(Paint.Cap.ROUND);
		mPaint.setStrokeWidth(20);

	}

	private Paint mPaint;

	public class CustomView extends View {

		@SuppressWarnings("deprecation")
		public CustomView(Context c) {

			super(c);
			Display Disp = getWindowManager().getDefaultDisplay();
			DrawBitmap = Bitmap.createBitmap(Disp.getWidth(), Disp.getHeight(),
					Bitmap.Config.ARGB_4444);

			mCanvas = new Canvas(DrawBitmap);

			mPath = new Path();
			DrawBitmapPaint = new Paint(Paint.DITHER_FLAG);
		}

		@Override
		protected void onSizeChanged(int w, int h, int oldw, int oldh) {
			super.onSizeChanged(w, h, oldw, oldh);
		}

		@Override
		protected void onDraw(Canvas canvas) {
			setDrawingCacheEnabled(true);
			canvas.drawBitmap(DrawBitmap, 0, 0, DrawBitmapPaint);
			canvas.drawPath(mPath, mPaint);
			canvas.drawRect(mY, 0, mY, 0, DrawBitmapPaint);
		}

		private float mX, mY;
		private static final float TOUCH_TOLERANCE = 4;

		private void touch_start(float x, float y) {
			mPath.reset();
			mPath.moveTo(x, y);
			mX = x;
			mY = y;
		}

		private void touch_move(float x, float y) {
			float dx = Math.abs(x - mX);
			float dy = Math.abs(y - mY);
			if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
				mPath.quadTo(mX, mY, (x + mX) / 2, (y + mY) / 2);
				mX = x;
				mY = y;
			}
		}

		private void touch_up() {
			mPath.lineTo(mX, mY);

			mCanvas.drawPath(mPath, mPaint);

			mPath.reset();
		}

		@Override
		public boolean onTouchEvent(MotionEvent event) {
			float x = event.getX();
			float y = event.getY();

			switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				touch_start(x, y);
				invalidate();
				break;
			case MotionEvent.ACTION_MOVE:
				touch_move(x, y);
				invalidate();
				break;
			case MotionEvent.ACTION_UP:
				touch_up();
				invalidate();
				break;
			}
			return true;
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
        mPaint.setXfermode(null);
		switch (item.getItemId()) {
		case R.id.erase: 
		       mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
		       break;
		case R.id.DELETE: 
		     View =  new CustomView(this);
		       break;
		case R.id.draw: 
		       mPaint.setXfermode(null);
		       
		       break;
		case R.id.Save:
			String pattern = "mm ss";
			SimpleDateFormat formatter = new SimpleDateFormat(pattern);
			String time = formatter.format(new Date());
			String path = ("/d-codepages" + time + ".png");

			File file = new File(Environment.getExternalStorageDirectory()
					+ path);

			try {
				DrawBitmap.compress(Bitmap.CompressFormat.PNG, 100,
						new FileOutputStream(file));
				Toast.makeText(this, "File Saved ::" + path, Toast.LENGTH_SHORT)
						.show();
			} catch (Exception e) {
				Toast.makeText(this, "ERROR" + e.toString(), Toast.LENGTH_SHORT)
						.show();
			}

		}
		return super.onOptionsItemSelected(item);
	}

}
