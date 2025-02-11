package dev.utils.app;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;

import dev.DevUtils;
import dev.utils.LogPrintUtils;

/**
 * detail: 颜色状态列表工具类
 * @author Ttt
 * <pre>
 *     @see <a href="https://blog.csdn.net/wuqilianga/article/details/72964884"/>
 *     @see <a href="https://blog.csdn.net/CrazyMo_/article/details/53456541"/>
 *     <p></p>
 *     android:state_active	        是否处于激活状态
 *     android:state_checkable	    是否可勾选
 *     android:state_checked	    是否已勾选
 *     android:state_enabled	    是否可用
 *     android:state_first	        是否开始状态
 *     android:state_focused	    是否已获取焦点
 *     android:state_last	        是否处于结束
 *     android:state_middle	        是否处于中间
 *     android:state_pressed	    是否处于按下状态
 *     android:state_selected	    是否处于选中状态
 *     android:state_window_focused	是否窗口已获取焦点
 * </pre>
 */
public final class StateListUtils {

    private StateListUtils() {
    }

    // 日志 TAG
    private static final String TAG = StateListUtils.class.getSimpleName();

    /**
     * 获取 ColorStateList
     * @param id resource identifier of a {@link ColorStateList}
     * @return {@link ColorStateList}
     */
    public static ColorStateList getColorStateList(@ColorRes final int id) {
        try {
            return ContextCompat.getColorStateList(DevUtils.getContext(), id);
        } catch (Exception e) {
            LogPrintUtils.eTag(TAG, e, "getColorStateList");
        }
        return null;
    }

    // ================
    // = 设置字体颜色 =
    // ================

    // ==============
    // = 字符串颜色 =
    // ==============

    /**
     * 创建 ColorStateList => createColorStateList("#ffffffff", "#ff44e6ff")
     * @param pressed 按下状态
     * @param normal  默认状态
     * @return {@link ColorStateList}
     */
    public static ColorStateList createColorStateList(final String pressed, final String normal) {
        // 颜色值
        int[] colors = new int[]{Color.parseColor(pressed), Color.parseColor(normal)};
        // 状态值
        int[][] states = new int[2][];
        states[0] = new int[]{android.R.attr.state_pressed}; // 选中状态
        states[1] = new int[]{}; // 默认状态
        // 生成 ColorStateList
        return new ColorStateList(states, colors);
    }

    /**
     * 创建 ColorStateList
     * @param selected 选中状态
     * @param pressed  按下状态
     * @param normal   默认状态
     * @return {@link ColorStateList}
     */
    public static ColorStateList createColorStateList(final String selected, final String pressed, final String normal) {
        // 颜色值
        int[] colors = new int[]{Color.parseColor(selected), Color.parseColor(pressed), Color.parseColor(normal)};
        // 状态值
        int[][] states = new int[3][];
        states[0] = new int[]{android.R.attr.state_selected}; // 选中状态
        states[1] = new int[]{android.R.attr.state_pressed}; // 点击状态
        states[2] = new int[]{}; // 默认状态
        // 生成 ColorStateList
        return new ColorStateList(states, colors);
    }

    /**
     * 创建 ColorStateList
     * @param selected 选中状态
     * @param pressed  按下状态
     * @param focused  获取焦点状态
     * @param checked  已勾选状态
     * @param normal   默认状态
     * @return {@link ColorStateList}
     */
    public static ColorStateList createColorStateList(final String selected, final String pressed,
                                                      final String focused, final String checked,
                                                      final String normal) {
        // 颜色值
        int[] colors = new int[]{Color.parseColor(selected), Color.parseColor(pressed),
                Color.parseColor(focused), Color.parseColor(checked), Color.parseColor(normal)};
        // 状态值
        int[][] states = new int[5][];
        states[0] = new int[]{android.R.attr.state_selected}; // 选中状态
        states[1] = new int[]{android.R.attr.state_pressed}; // 点击状态
        states[2] = new int[]{android.R.attr.state_focused}; // 获取焦点状态
        states[3] = new int[]{android.R.attr.state_checked}; // 选中状态
        states[4] = new int[]{}; // 默认状态
        // 生成 ColorStateList
        return new ColorStateList(states, colors);
    }

    // =======
    // = int =
    // =======

    /**
     * 创建 ColorStateList => createColorStateList(R.color.whilte, R.color.black)
     * @param pressed 按下状态
     * @param normal  默认状态
     * @return {@link ColorStateList}
     */
    public static ColorStateList createColorStateList(@ColorRes final int pressed, @ColorRes final int normal) {
        Context context = DevUtils.getContext();
        // 颜色值
        int[] colors = new int[2];
        colors[0] = ContextCompat.getColor(context, pressed);
        colors[1] = ContextCompat.getColor(context, normal);
        // 状态值
        int[][] states = new int[2][];
        states[0] = new int[]{android.R.attr.state_pressed};
        states[1] = new int[]{};
        // 生成 ColorStateList
        return new ColorStateList(states, colors);
    }

    /**
     * 创建 ColorStateList
     * @param selected 选中状态
     * @param pressed  按下状态
     * @param normal   默认状态
     * @return {@link ColorStateList}
     */
    public static ColorStateList createColorStateList(@ColorRes final int selected, @ColorRes final int pressed, @ColorRes final int normal) {
        Context context = DevUtils.getContext();
        // 颜色值
        int[] colors = new int[3];
        colors[0] = ContextCompat.getColor(context, selected);
        colors[1] = ContextCompat.getColor(context, pressed);
        colors[2] = ContextCompat.getColor(context, normal);
        // 状态值
        int[][] states = new int[3][];
        states[0] = new int[]{android.R.attr.state_selected};
        states[1] = new int[]{android.R.attr.state_pressed};
        states[2] = new int[]{};
        // 生成 ColorStateList
        return new ColorStateList(states, colors);
    }

    /**
     * 创建 ColorStateList
     * @param selected 选中状态
     * @param pressed  按下状态
     * @param focused  获取焦点状态
     * @param checked  已勾选状态
     * @param normal   默认状态
     * @return {@link ColorStateList}
     */
    public static ColorStateList createColorStateList(@ColorRes final int selected, @ColorRes final int pressed,
                                                      @ColorRes final int focused, @ColorRes final int checked,
                                                      @ColorRes final int normal) {
        Context context = DevUtils.getContext();
        // 颜色值
        int[] colors = new int[5];
        colors[0] = ContextCompat.getColor(context, selected);
        colors[1] = ContextCompat.getColor(context, pressed);
        colors[2] = ContextCompat.getColor(context, focused);
        colors[3] = ContextCompat.getColor(context, checked);
        colors[4] = ContextCompat.getColor(context, normal);
        // 状态值
        int[][] states = new int[5][];
        states[0] = new int[]{android.R.attr.state_selected};
        states[1] = new int[]{android.R.attr.state_pressed};
        states[2] = new int[]{android.R.attr.state_focused};
        states[3] = new int[]{android.R.attr.state_checked};
        states[4] = new int[]{};
        // 生成 ColorStateList
        return new ColorStateList(states, colors);
    }

    // =========================
    // = 设置背景切换 Drawable =
    // =========================

    /**
     * 创建 StateListDrawable => view.setBackground(Drawable)
     * @param pressed 按下状态
     * @param normal  默认状态
     * @return {@link StateListDrawable}
     */
    public static StateListDrawable newSelector(@DrawableRes final int pressed, @DrawableRes final int normal) {
        Context context = DevUtils.getContext();
        // 获取 Drawable
        Drawable pressedDraw = ContextCompat.getDrawable(context, pressed);
        Drawable normalDraw = ContextCompat.getDrawable(context, normal);
        // 创建 StateListDrawable
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, pressedDraw);
        stateListDrawable.addState(new int[]{}, normalDraw);
        return stateListDrawable;
    }

    /**
     * 创建 StateListDrawable
     * @param selected 选中状态
     * @param pressed  按下状态
     * @param normal   默认状态
     * @return {@link StateListDrawable}
     */
    public static StateListDrawable newSelector(@DrawableRes final int selected, @DrawableRes final int pressed, @DrawableRes final int normal) {
        Context context = DevUtils.getContext();
        // 获取 Drawable
        Drawable selectedDraw = ContextCompat.getDrawable(context, selected);
        Drawable pressedDraw = ContextCompat.getDrawable(context, pressed);
        Drawable normalDraw = ContextCompat.getDrawable(context, normal);
        // 创建 StateListDrawable
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_selected}, selectedDraw);
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, pressedDraw);
        stateListDrawable.addState(new int[]{}, normalDraw);
        return stateListDrawable;
    }

    /**
     * 创建 StateListDrawable
     * @param selected 选中状态
     * @param pressed  按下状态
     * @param focused  获取焦点状态
     * @param checked  已勾选状态
     * @param normal   默认状态
     * @return {@link StateListDrawable}
     */
    public static StateListDrawable newSelector(@DrawableRes final int selected, @DrawableRes final int pressed,
                                                @DrawableRes final int focused, @DrawableRes final int checked,
                                                @DrawableRes final int normal) {
        Context context = DevUtils.getContext();
        // 获取 Drawable
        Drawable selectedDraw = ContextCompat.getDrawable(context, selected);
        Drawable pressedDraw = ContextCompat.getDrawable(context, pressed);
        Drawable focusedDraw = ContextCompat.getDrawable(context, focused);
        Drawable checkedDraw = ContextCompat.getDrawable(context, checked);
        Drawable normalDraw = ContextCompat.getDrawable(context, normal);
        // 创建 StateListDrawable
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_selected}, selectedDraw);
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, pressedDraw);
        stateListDrawable.addState(new int[]{android.R.attr.state_focused}, focusedDraw);
        stateListDrawable.addState(new int[]{android.R.attr.state_checked}, checkedDraw);
        stateListDrawable.addState(new int[]{}, normalDraw);
        return stateListDrawable;
    }

    // =========================
    // = 设置背景切换 Drawable =
    // =========================

    /**
     * 创建 StateListDrawable => view.setBackground(Drawable)
     * @param pressed 按下状态
     * @param normal  默认状态
     * @return {@link StateListDrawable}
     */
    public static StateListDrawable newSelector(final Drawable pressed, final Drawable normal) {
        // 创建 StateListDrawable
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, pressed);
        stateListDrawable.addState(new int[]{}, normal);
        return stateListDrawable;
    }

    /**
     * 创建 StateListDrawable
     * @param selected 选中状态
     * @param pressed  按下状态
     * @param normal   默认状态
     * @return {@link StateListDrawable}
     */
    public static StateListDrawable newSelector(final Drawable selected, final Drawable pressed, final Drawable normal) {
        // 创建 StateListDrawable
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_selected}, selected);
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, pressed);
        stateListDrawable.addState(new int[]{}, normal);
        return stateListDrawable;
    }

    /**
     * 创建 StateListDrawable
     * @param selected 选中状态
     * @param pressed  按下状态
     * @param focused  获取焦点状态
     * @param checked  已勾选状态
     * @param normal   默认状态
     * @return {@link StateListDrawable}
     */
    public static StateListDrawable newSelector(final Drawable selected, final Drawable pressed,
                                                final Drawable focused, final Drawable checked,
                                                final Drawable normal) {
        // 创建 StateListDrawable
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_selected}, selected);
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, pressed);
        stateListDrawable.addState(new int[]{android.R.attr.state_focused}, focused);
        stateListDrawable.addState(new int[]{android.R.attr.state_checked}, checked);
        stateListDrawable.addState(new int[]{}, normal);
        return stateListDrawable;
    }
}