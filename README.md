## Building

Install Node dependencies:

    npm install
    npx tailwindcss init
    npx tailwindcss build css/style.css -o resources/css/style.css

### Development

    clojure -A:dev

### Release

    clojure -A:main
    clojure -A:render
    npm run package

### Run tests from command line (for CI)

    clojure -A:test