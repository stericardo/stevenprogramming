//Packages
var gulp = require('gulp'),
    concat = require('gulp-concat'),
    uglify = require('gulp-uglify'),
    pump = require('pump'),
    cleanCSS = require('gulp-clean-css'),
    sourcemaps = require('gulp-sourcemaps'),
    less = require('gulp-less'),
    htmlhint = require('gulp-htmlhint'),
    htmlmin = require('gulp-htmlmin'),
    ngAnnotate = require('gulp-ng-annotate'),
    ngTemplates = require('gulp-ng-templates'),
    copy = require('gulp-contrib-copy'),
    path = require('path'),
    debug = require('gulp-debug'),
    del = require('del'),
    browserSync = require('browser-sync').create(),
    eslint = require('gulp-eslint');

//Paths
var src = './src',
    src_js = path.join(src, '/js'),
    src_js_vendor = path.join(src_js, '/vendor'),
    src_js_site = path.join(src_js, '/site'),
    src_css = path.join(src, '/css'),
    src_images = path.join(src, '/images'),
    src_fonts = path.join(src, '/fonts'),
    src_data = path.join(src, '/data'),
    src_views = path.join(src, '/views'),
    dist = './dist',
    dist_js = path.join(dist, '/js'),
    dist_css = path.join(dist, '/css'),
    dist_images = path.join(dist, '/images'),
    dist_fonts = path.join(dist, '/fonts'),
    dist_data = path.join(dist, '/data');

// Clean folders
gulp.task('clean', function () {
    'use strict';
    return del.sync([dist]);
});

gulp.task('eslint', function () {
    'use strict';
    return gulp.src([
        path.join(src_js_site, '/{,**/}*.js'),
        '!' + path.join(src_js_site, '/templates-angular.js')
    ])
    .pipe(eslint())
    .pipe(eslint.format())
    .pipe(eslint.failOnError());
});

// HTMLHint, Code Verifier
gulp.task('htmlhint', function () {
    'use strict';
    return gulp.src([
        path.join(src, '/{,**/}*.html'),
        path.join(src_js_site, '/{,**/}*.html')
    ])
    .pipe(htmlhint('.htmlhintrc'))
    .pipe(htmlhint.failReporter());
});

// Compile Less
gulp.task('less', function () {
    'use strict';
    return gulp.src(
        path.join(src_css, '/*.less')
    )
    .pipe(less({
        paths: [
            path.join(src_css, '/vendor'),
            path.join(src_css, '/partials')
        ]
    }))
    .pipe(gulp.dest(dist_css))
    .pipe(browserSync.stream());
});

// Copy Static Files
gulp.task('copy:static', function () {
    'use strict';
    return gulp.src([
        path.join(src_images, '/{,**/}*'),
        path.join(src, '/*.html'),
        path.join(src_fonts, '/{,**/}*'),
        path.join(src_data, '/{,**/}*'),
        path.join(src_views, '/{,**/}*')
    ],
    {
        "base" : src
    })
    .pipe(copy())
    .pipe(gulp.dest(dist))
    .pipe(browserSync.stream());
});

// Angular Templates Compiler (HTML to JS)
gulp.task('ngtemplates', function () {
    'use strict';
    return gulp.src(
        path.join(src_js_site, '/{,**/}/views/*.html')
    )
    .pipe(htmlmin({
        collapseWhitespace: true
    }))
    .pipe(ngTemplates({
        filename: 'templates-angular.js',
        module: 'metroApp.templates',
        standalone: true
    }))
    .pipe(gulp.dest(src_js_site));
});

// File Concatenation for JavaScript files
gulp.task('concat:libraries', function() {
    'use strict';
    return gulp.src(
        path.join(src_js_vendor, '/{,**/}*.js')
    )
    .pipe(concat('libraries.js'))
    .pipe(gulp.dest(dist_js));
});

gulp.task('concat:site', ['ngtemplates'], function() {
    'use strict';
    return gulp.src([
        path.join(src_js_site, '/{,**/}*.module.js'),
        path.join(src_js_site, '/{,**/}*.*.js'),
        path.join(src_js_site, '/templates-angular.js'),
        path.join(src_js_site, '/app*.js')
    ])
    .pipe(concat('site.js'))
    .pipe(ngAnnotate())
    .pipe(gulp.dest(dist_js));
});

// JavaScript Minimizer
gulp.task('compress:js', ['concat:site'], function (cb) {
    'use strict';
    return pump([
        gulp.src([
            path.join(dist_js, '/{,**/}*.js')
        ]),
        uglify(),
        gulp.dest(dist_js)
    ], cb);
});

// CSS Minimizer
gulp.task('compress:css', ['less'], function() {
    'use strict';
    return gulp.src([
        path.join(dist_css, '/{,**/}*.css')
    ])
    .pipe(sourcemaps.init())
    .pipe(cleanCSS({compatibility: 'ie8'}))
    .pipe(sourcemaps.write('./'))
    .pipe(gulp.dest(dist_css));
});

// Helper Tasks
gulp.task('linter', ['eslint', 'htmlhint']);
gulp.task('build:js', ['ngtemplates', 'concat:libraries', 'concat:site']);
gulp.task('build:css', ['less']);
gulp.task('build:optimize', ['compress:js', 'compress:css']);
gulp.task('build:dev', ['clean', 'linter', 'less', 'copy:static', 'build:js']);
gulp.task('build:prod', ['build:dev', 'build:optimize']);


// User Tasks
gulp.task('serve', ['build:dev'], function() {
    browserSync.init({
        server: dist,
        reloadDelay: 2000
    });

    gulp.watch(
        path.join(src_css, '/{,**/}*.less')
    , ['less']);

    gulp.watch([
        path.join(src, '/*.html'),
        path.join(src_images, '/{,**/}*'),
        path.join(src_fonts, '/{,**/}*'),
        path.join(src_data, '/{,**/}*'),
        path.join(src_views, '/{,**/}*')
    ], ['htmlhint', 'copy:static']);

    gulp.watch([
        path.join(src_js, '/{,**/}*.js'),
        path.join(src_js_site, '/{,**/}/views/*.html')
    ], ['eslint', 'build:js']);

    gulp.watch("src/**").on('change', browserSync.reload);
});

gulp.task('build', ['build:prod']);
gulp.task('default', ['serve']);