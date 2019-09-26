"use strict";
function MediaObject(e) {
	!function(e) {
		if (!e.element)
			throw new Error("missing container element");
		if (!e.url && !e.title_id)
			throw new Error("missing url and title_id")
	}(e);
	var o, t = e || {}, n = this, a = e.element, r = [ "accelerometer",
			"magnetometer", "ambient-light-sensor", "camera", "fullscreen",
			"microphone", "gyroscope", "autoplay", "encrypted-media",
			"picture-in-picture" ], i = e.disableFeaturePolicy || [], c = {
		dev : {
			hostname : "https://lsso.lazr.ci.alexanderstreet.com"
		},
		prod : {
			hostname : "https://search.alexanderstreet.com"
		},
		preprod : {
			hostname : "https://pre-prod.alexanderstreet.com"
		},
		test : {
			hostname : window.location.origin
		}
	}, s = e.env || "dev", l = e.features || {
		autoplay : !0,
		externalStylesheet : "",
		language : "en",
		embedsCode : !1,
		embedsHost : ""
	}, u = e.width || (!0 === e.video ? "800px" : "1px"), p = e.height
			|| (!0 === e.video ? "600px" : "1px"), d = {}, m = {}, g = [
			"ready", "setupError", "remove", "playlist", "playlistItem",
			"bufferChange", "play", "pause", "buffer", "idle", "complete",
			"firstFrame", "error", "seek", "seeked", "time", "mute", "volume",
			"levels", "levelsChanged", "visualQuality", "captionsList",
			"captionsChanged", "detailsReady", "transcriptReady",
			"transcriptRenderComplete" ], h = [ "next", "getPlaylist",
			"getPlaylistItem|index", "getPlaylistIndex", "playlistItem|index",
			"getBuffer", "play|state", "pause|state", "stop", "getState",
			"getPosition", "getDuration", "seek|position", "getMute",
			"setMute|state", "getVolume", "setVolume|volume",
			"getQualityLevels", "getCurrentQuality", "getVisualQuality",
			"setCurrentQuality|index", "setCaptions|styles", "getCaptionsList",
			"getCurrentCaptions", "setCurrentCaptions|index",
			"setTranscriptSearchTerm|term", "changeLanguage|languageCode" ], f = e.url, y = e.title_id
			|| "", b = e.app_id || "", w = e.customer_id || "", v = e.account_id
			|| "", j = e.usage_group_id || "", C = e.object_id || "", x = e.pqauth
			|| "", _ = e.duration || "", k = e.token || "";
	0 < i.length && (r = r.map(function(t) {
		return i.forEach(function(e) {
			t === e && (t = e + " 'none'")
		}), t
	})), y ? f = c[s].hostname + "/media-object/" + y + "?app_id=" + b
			+ "&customer_id=" + w + "&account_id=" + v + "&usage_group_id=" + j
			+ "&object_id=" + C + "&pqauth=" + x + "&duration=" + _ + "&token="
			+ k : /https?:\/\//.test(f) || (f = c[s].hostname + f), f = f + "#"
			+ encodeURIComponent(JSON.stringify(l)), t.on = t.on || {};
	for (var E = 0; E < g.length; E++) {
		var M = g[E];
		"function" == typeof t.on[M] ? d[M] = t.on[M] : d[M] = function(t) {
			return function(e) {
				I(t + " triggered", e)
			}
		}(M)
	}
	for (E = 0; E < h.length; E++) {
		var O = h[E].split("|")[0];
		m[O] = {}, n[O] = function(t) {
			return function() {
				var e = Array.prototype.slice.call(arguments);
				I("media object calling " + t), o[t].apply(o, e)
			}
		}(O)
	}
	function I() {
		var e = "background: blue; color: yellow";
		console.log("%c <----------", e), console.log(arguments), console.log(
				"%c ----------\x3e", e)
	}
			n.getElement = function() {
				return a
			},
			n.getIframe = function() {
				return a.getElementsByTagName("iframe")[0]
			},
			n.destroy = function() {
				return o.destroy()
			},
			MediaObject.instances.push(this),
			o = new easyXDM.Rpc({
				remote : f,
				container : a,
				hash : !1,
				props : {
					allowFullscreen : "on",
					allow : r.join("; "),
					frameborder : 0,
					scrolling : "no",
					style : {
						width : u,
						height : p
					}
				},
				onReady : function() {
				}
			}, {
				local : d,
				remote : m
			}),
			window.genEventsDoc = function() {
						output = "",
						g
								.forEach(function(e) {
											e = e.toLowerCase(),
											output += "\n    * @param {callback} options.on."
													.concat(
															e,
															"\n    * {@link https://developer.jwplayer.com/jw-player/docs/javascript-api-reference/#jwplayeron")
													.concat(e, "}\n  "),
											console.log(output)
								})
			},
			window.genMethodsDoc = function() {
						output = "",
						h
								.forEach(function(e) {
									var t = e.split("|"), o = t[0], n = o
											.toLowerCase(), a = 1 < t.length ? t[1]
											: "";
											output += "\n  /**\n   * {@link https://developer.jwplayer.com/jw-player/docs/javascript-api-reference/#jwplayer"
													.concat(n + a,
															"}\n   * @method MediaObject#")
													.concat(o),
											output += a ? "\n   * @param {*} "
													.concat(a) : "",
											output += "\n   * @param {MediaObject~successCallback} onSuccess - callback to process API return\n   * @param {MediaObject~errorCallback} onError - callback to deal with error\n   *\n   * @example",
											output += a ? "\n   * mediaObject."
													.concat(o, "(")
													.concat(a,
															", onSuccess, onError)\n   */")
													: "\n   * mediaObject."
															.concat(o,
																	"(onSuccess, onError)\n   */\n")
								}), console.log(output)
			}
}
MediaObject.instances = [], MediaObject.destroyAll = function() {
	MediaObject.instances.forEach(function(e) {
		e.destroy()
	})
};