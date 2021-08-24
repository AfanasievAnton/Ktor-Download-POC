import SwiftUI
import shared

struct ContentView: View {
    
    let dataHandler: DataHandler
    
    init() {
        dataHandler = DataHandlerProvider().createDataHandler()
    }
    
	var body: some View {
        Button("Download") {
            dataHandler.download()
        }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
