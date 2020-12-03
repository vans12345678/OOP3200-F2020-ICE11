package ca.durhamcollege.utility;
import java.util.Random;


//Static container class
public class Mathf
{
    public static final float Epsilon = 0.00001f;
    public static final float EpsilonNormalSqrt = 1e-15f;
    public static final float PI = 3.141593f;
    public static final float Infinity = Float.POSITIVE_INFINITY;
    public static final float NegativeInfinity = Float.NEGATIVE_INFINITY;
    public static final float Deg2Rad = 0.01745329f;
    public static final float Rad2Deg = 57.29578f;

    //Protects the Mathf class from being instantiated
    private Mathf(){}

    public static float RandomRange(final float min, final float max)
    {
        Random random = new Random();
        return (random.nextFloat() * (max - min)) + min;
    }

    public static int RandomRange(final int min, final int max)
    {
        Random random = new Random();
        return (random.nextInt() * (max - min)) + min;
    }

    float Sin(final float f)
{
    return (float)(Math.sin((double)(f)));
}

    float Cos(final float f)
{
    return (float)(Math.cos((double)(f)));
}

    float Tan(final float f)
{
    return (float)(Math.tan((double)(f)));
}

    float Asin(final float f)
{
    return (float)(Math.sin((double)(f)));
}

    float Acos (final float f)
{
    return (float)(Math.cos((double)(f)));
}

    float Atan(final float f)
{
    return (float)(Math.atan((double)(f)));
}

    float Atan2(final float y, final float x)
{
    return (float)(Math.atan2((double)(y), (double)(x)));
}

    public static float Sqrt(final float f) {
        return (float) (Math.sqrt(f));
    }

    float Abs(final float f)
{
    return Math.abs(f);
}

    int Abs(int value)
{
    return Math.abs(value);
}

    float Min(final float a, final float b)
{
    if ((double)(a) < (double)(b))
    {
        return a;
    }
    return b;
}

    int Min(final int a, final int b)
{
    if (a < b)
    {
        return a;
    }
    return b;
}

    float Max(final float a, final float b)
{
    if ((double)(a) > (double)(b))
    {
        return a;
    }
    return b;
}

    int Max(final int a, final int b)
{
    if (a > b)
    {
        return a;
    }
    return b;
}

    float Pow(final float f, final float p)
{
    return (float)(Math.pow((double)(f), (double)(p)));
}

    float Exp(final float power)
{
    return (float)(Math.exp((double)(power)));
}

    float Log(final float f)
{
    return (float)(Math.log((double)(f)));
}

    float Log10(final float f)
{
    return (float)(Math.log10((double)(f)));
}

    float Ceil(final float f)
{
    return (float)(Math.ceil((double)(f)));
}

    float Floor(final float f)
{
    return (float)(Math.floor((double)(f)));
}

    float Round(final float f)
{
    return (float)(Math.round((double)(f)));
}

    int CeilToInt(final float f)
{
    return (int)(Math.ceil((double)(f)));
}

    int FloorToInt(final float f)
{
    return (int)(Math.floor((double)(f)));
}

    int RoundToInt(final float f)
{
    return (int)(Math.round((double)(f)));
}

    float Sign(final float f)
{
    return (double)(f) >= 0.0 ? 1.0f : -1.0f;
}

    float Clamp(float value, final float min, final float max)
{
    if ((double)(value) < (double)(min))
    {
        value = min;
    }
	else if ((double)(value) > (double)(max))
    {
        value = max;
    }
    return value;
}

    int Clamp(int value, final int min, final int max)
{
    if (value< min)
    {
        value = min;
    }
    else if (value > max)
    {
        value = max;
    }
    return value;
}

    float Clamp01(final float value)
{
    if ((double)(value) < 0.0)
    {
        return 0.0f;
    }
    if ((double)(value) > 1.0)
    {
        return 1.0f;
    }
    return value;
}

    float Lerp(final float a, final float b, final float t)
{
    return a + (b - a) * Clamp01(t);
}

    float LerpUnclamped(final float a, final float b, final float t)
{
    return a + (b - a) * t;
}

    float LerpAngle(final float a, final float b, final float t)
{
    float num = Repeat(b - a, 360.0f);
    if ((double)(num) > 180.0)
    {
        num -= 360.0f;
    }
    return a + num * Clamp01(t);
}

    float MoveTowards(final float current, final float target, final float max_delta)
{
    if ((double)(Abs(target - current)) <= (double)(max_delta))
    {
        return target;
    }
    return current + Sign(target - current) * max_delta;
}

    float MoveTowardsAngle(final float current, float target, final float max_delta)
{
    target = current + DeltaAngle(current, target);
    return MoveTowards(current, target, max_delta);
}

    float SmoothStep(final float from, final float to, float t)
{
    t = Clamp01(t);
    t = (float)(-2.0 * (double)(t) * (double)(t) * (double)(t) + 3.0 * (double)(t) * (double)(t));
    return (float)((double)(to) * (double)(t) + (double)(from) * (1.0 - (double)(t)));
}

    boolean Approximately(final float a, final float b)
{
    return (double)(Abs(b - a)) < (double)(Max(1E-06f * Max(Abs(a), Abs(b)), Epsilon * 8.0f));
}

    float Repeat(final float t, final float length)
{
    return t - Floor(t / length) * length;
}

    float PingPong(float t, final float length)
{
    t = Repeat(t, length * 2.0f);
    return length - Abs(t - length);
}

    float InverseLerp(final float a, final float b, final float value)
{
    if ((double)(a) != (double)(b))
    {
        return Clamp01((float)(((double)(value) - (double)(a)) / ((double)(b) - (double)(a))));
    }
    return 0.0f;
}

    float DeltaAngle(final float current, final float target)
{
    float num = Repeat(target - current, 360.0f);
    if ((double)(num) > 180.0)
    {
        num -= 360.0f;
    }
    return num;
}



}
