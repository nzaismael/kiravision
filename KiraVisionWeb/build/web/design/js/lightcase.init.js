	jQuery(document).ready(function($) {
		$('a[data-rel="lightcase:oTables"]').lightcase({
			transition: 'scrollTop',
			speedIn:'600',
			swipe: true,
			useKeys: true,
			overlayOpacity:0.8,
			title:'',
			showSequenceInfo: false,
			iframe: {
				width:'auto',
				height:'300',
				frameborder: 0
			}

		});

		$('a[data-rel="lightcase:oSessions"]').lightcase({
			transition: 'scrollTop',
			speedIn:'600',
			speedOut:'800',
			forceWidth:true,
			swipe: true,
			useKeys: true,
			overlayOpacity:0.8,
			title:'',
			showSequenceInfo: false,
			iframe: {
				width:'1000',
				height:'300',
				frameborder: 0
			}

		});


	});
