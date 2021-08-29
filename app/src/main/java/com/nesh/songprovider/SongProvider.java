package com.nesh.songprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;

import java.util.List;

public abstract class SongProvider extends ContentProvider {

    public abstract List<Song> getSongs(String query);

    @Override
    public final Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        String[] columns = {"title", "downloadUrl"};

        MatrixCursor cursor = new MatrixCursor(columns);

        List<Song> songs = getSongs(selection);

        songs.forEach(song -> {
            String[] values = {song.getTitle(), song.getDownloadUrl()};

            cursor.addRow(values);
        });

        return cursor;
    }

    @Override
    public final String getType(Uri uri) {
        return null;
    }

    @Override
    public final Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public final int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public final int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
